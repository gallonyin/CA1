package org.caworks.library.util.parser;

import android.util.Log;

import org.caworks.library.util.GLog;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * xml格式化，默认debug
 */
public class XmlParser {

    public static void printXml(String tag, String xml, String headString) {

        if (xml != null) {
            xml = XmlParser.formatXML(xml);
            xml = headString + "\n" + xml;
        } else {
            xml = headString + GLog.NULL_TIPS;
        }

        LogLineUtil.printLine(tag, true);
        String[] lines = xml.split(GLog.LINE_SEPARATOR);
        for (String line : lines) {
            if (!LogLineUtil.isEmpty(line)) {
                Log.d(tag, "║ " + line);
            }
        }
        LogLineUtil.printLine(tag, false);
    }

    public static String formatXML(String inputXML) {
        try {
            Source xmlInput = new StreamSource(new StringReader(inputXML));
            StreamResult xmlOutput = new StreamResult(new StringWriter());
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(xmlInput, xmlOutput);
            return xmlOutput.getWriter().toString().replaceFirst(">", ">\n");
        } catch (Exception e) {
            e.printStackTrace();
            return inputXML;
        }
    }

}
