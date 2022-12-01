package ua.khpi.oop.khelemendyk08;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLCreator {

    /**
     * Функція записує всю бібліотеку в xml файл
     * @param library бібліотека
     */
    static public void encode(List<Book> library){
        DocumentBuilder builder;

        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        }  catch (Exception e) {
            System.out.println("Не удалось сохранить\n");
            return;
        }
        
        Document document = builder.newDocument();

        Element root = document.createElement("root");
        document.appendChild(root);

        for (Book item : library) {
            Element book = document.createElement("book");
            root.appendChild(book);

            Element ISBN = document.createElement("ISBN");
            Element name = document.createElement("name");
            Element authors = document.createElement("authors");
            Element production = document.createElement("production");
            Element genre = document.createElement("genre");
            Element publicationDate = document.createElement("date");

            Text text = document.createTextNode(item.getISBN());
            book.appendChild(ISBN);
            ISBN.appendChild(text);

            text = document.createTextNode(item.getName());
            book.appendChild(name);
            name.appendChild(text);

            String temp = "";
            for (int j = 0; j < item.getAuthors().length; j++) {
                temp = temp.concat(item.getAuthors()[j]);
                if (j != item.getAuthors().length - 1) temp = temp.concat(",");
            }

            text = document.createTextNode(temp);
            book.appendChild(authors);
            authors.appendChild(text);

            text = document.createTextNode(item.getProduction());
            book.appendChild(production);
            production.appendChild(text);

            text = document.createTextNode(item.getGenre());
            book.appendChild(genre);
            genre.appendChild(text);

            text = document.createTextNode(Integer.toString(item.getPublicationDate()));
            book.appendChild(publicationDate);
            publicationDate.appendChild(text);
        }

        try {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.transform(new DOMSource(document), new StreamResult(new FileOutputStream("save.xml")));
            System.out.println("Успешно сохранено\n");
        } catch (Exception e) {
            System.out.println("Не удалось сохранить\n");
        }
    }

    /**
     * Функція перетворює дані з xml файлу в список книг
     * @return список книжок.
     */
    public static List<Book> decode() {
        List<Book> root = new ArrayList<>();
        File file = new File("save.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            Document doc = dbf.newDocumentBuilder().parse(file);
            Node rootNode = doc.getFirstChild();
            NodeList books = rootNode.getChildNodes();
            for (int i = 0; i < books.getLength(); i++){
                if (books.item(i).getNodeType() == Node.ELEMENT_NODE){
                    NodeList fields = books.item(i).getChildNodes();
                    root.add(
                            generate(fields));
                }
            }
            System.out.println("Успешно загружено\n");
        }  catch (Exception e) {
            System.out.println("Не удалось загрузить\n");
        }

        return root;
    }

    /**
     * Функція генерує книгу зі списку вузлів
     * @param fields список вузлів
     * @return книгу
     */
    private static Book generate(NodeList fields) {
        String[] array = new String[0];
        String[] temp = new String[5];
        int j = 0;
        for (int i = 0; i < fields.getLength(); i++) {
            if (fields.item(i).getNodeType() == Node.ELEMENT_NODE) {
                if (!fields.item(i).getNodeName().equals("authors"))
                    temp[j++] = fields.item(i).getFirstChild().getNodeValue();
                else
                    array = fields.item(i).getFirstChild().getNodeValue().split(",");
            }
        }

        return new Book(temp[0],temp[1],array,temp[2],temp[3],Integer.parseInt(temp[4]));
    }
}
