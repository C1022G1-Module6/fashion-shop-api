package vn.codegym.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class CustomInvoiceCodeGenerator implements IdentifierGenerator{

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object)
            throws HibernateException {

        String prefix = "HD";
        Connection connection = session.connection();

        try {
            Statement statement=connection.createStatement();

            ResultSet rs=statement.executeQuery("select count(code) as Id from invoice");

            if(rs.next())
            {
                int id=rs.getInt(1)+100001;
                String generatedId = prefix + new Integer(id).toString();
                System.out.println("Generated Id: " + generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return null;
    }
}

//public class CustomInvoiceCodeGenerator implements IdentifierGenerator{
////    private static final String PREFIX = "HD";
//
//    @Override
//    public Serializable generate(SessionImplementor session, Object object)
//            throws HibernateException {
//
//        String prefix = "HD";
//        Connection connection = session.connection();
//
//        try {
//            Statement statement=connection.createStatement();
//
//            ResultSet rs=statement.executeQuery("select count(code) as Id from invoice");
//
//            if(rs.next())
//            {
//                int id=rs.getInt(1)+101;
//                String generatedId = prefix + new Integer(id).toString();
//                System.out.println("Generated Id: " + generatedId);
//                return generatedId;
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//
//        return null;
//    }
////    private static final int INITIAL_VALUE = 100000;
////
////    @Override
////    public Serializable generate(
////            SharedSessionContractImplementor session, Object obj)
////            throws HibernateException {
////
////        String query = String.format("select %s from %s",
////                session.getEntityPersister(obj.getClass().getName(), obj)
////                        .getIdentifierPropertyName(),
////                obj.getClass().getSimpleName());
////
////        Stream<String> ids = session.createQuery(query).stream()
////                .map(Object::toString);
////
////        Integer max = ids.filter(s -> s.startsWith(PREFIX))
////                .map(s -> s.replace(PREFIX, ""))
////                .mapToInt(Integer::parseInt)
////                .max()
////                .orElse(INITIAL_VALUE - 1);
////
////        return PREFIX + String.format("%05d", max + 1);
////    }
//}