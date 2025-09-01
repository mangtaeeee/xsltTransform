package com.example.demo.service;

import org.springframework.stereotype.Service;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringWriter;

@Service
public class XslTransformService {

    public String transformXmlWithXsl(String xmlPath, String xslPath) {
        try {
            // XSLT 변환기 생성
            TransformerFactory factory = TransformerFactory.newInstance();
            // XSLT 파일 로드
            Source xslt = new StreamSource(new File(xslPath));
            Transformer transformer = factory.newTransformer(xslt);

            // XML 파일 로드
            Source xml = new StreamSource(new File(xmlPath));

            // 변환 결과를 문자열로 저장
            StringWriter writer = new StringWriter();
            transformer.transform(xml, new StreamResult(writer));

            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException("XSL 변환 중 오류 발생", e);
        }
    }
}