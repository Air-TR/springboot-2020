//package com.tr.springboot.util.special;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Map;
//
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.pdf.AcroFields;
//import com.lowagie.text.pdf.AcroFields.Item;
//import com.lowagie.text.pdf.BaseFont;
//import com.lowagie.text.pdf.PdfReader;
//import com.lowagie.text.pdf.PdfStamper;
//
///**
// * PDF 工具类
// *
// * @author rtao
// * @date 2022/1/17 18:12
// */
//public class PDFUtil {
//
//    public static void main(String[] args) {
//        try {
//            fillTemplate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 填充模板
//     * @throws IOException
//     * @throws DocumentException
//     */
//    @SuppressWarnings("unchecked")
//    public static void fillTemplate() throws IOException, DocumentException {
//
//        PdfReader reader = new PdfReader("/Users/taorun/pdf-template.pdf"); // 模版文件目录
//        PdfStamper ps = new PdfStamper(reader, new FileOutputStream("/Users/taorun/fillTemplate.pdf")); // 生成的输出流
//
//        AcroFields s = ps.getAcroFields();
//
//        Map<String, Object> fieldMap = s.getFields(); // pdf表单相关信息展示
//        for (Map.Entry<String, Object> entry : fieldMap.entrySet()) {
//            String name = entry.getKey(); // name就是pdf模版中各个文本域的名字
//            Item item = (Item) entry.getValue();
//            System.out.println("[name]:" + name + ", [value]: " + item);
//        }
//
//        BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//        s.addSubstitutionFont(bf); // 解决中文
//
//        s.setField("@condition", "厂家机型 : 青岛纺机（A186）\n\n" + "纤维类型 : 中支纱（32~60S）\n\n" + "纤维类型 : 中支纱（32~60S）\n\n"
//                + "厂家机型 : 青岛纺机（A186）\n\n" + "纤维类型 : 中支纱（32~60S）\n\n" + "纤维类型 : 中支纱（32~60S）\n\n");
//        s.setField("@result", "结果1\n结果2\n结果3\n结果4\n结果5\n结果6\n结果7\n");
////		s.setField("@fibretype", "棉");
////		s.setField("@fibrevalue", "细绒棉");
////		s.setField("@spinningtype", "低支纱（32S以下）");
////		s.setField("@throughput", "中产（30~80kg/h）");
////		s.setField("@cylinderspeed", "高速（500r/min以上）");
////		s.setField("@quality", "Uster 95%");
////
////		s.setField("@pricks", "pricks");
////		s.setField("@cylinder", "cylinder");
////		s.setField("@flatclothing", "flatclothing");
////		s.setField("@tops", "tops");
////		s.setField("@astoria", "astoria");
//
//        ps.setFormFlattening(true); // 设置为true生成的PDF不可修改，false可修改
//        ps.close();
//        reader.close();
//    }
//
//}
