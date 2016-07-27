package CreateAccountUnitTest;

import Model.ReadExcel;
import Model.Hospital;
import org.junit.Test;
import utils.BinarySearchTree;

import java.util.List;

/**
 * Created by tkanchanawanchai6403 on 7/25/2016.
 */
public class ReadExcelTest
{
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String latitude;
    private String longitude;
    private String phoneNo;
    private String photo;

    @Test
    public void excelReader() throws Exception
    {
        BinarySearchTree<Hospital> hospitalBSTree = new BinarySearchTree<Hospital>();
        List hospitalList = ReadExcel.excelReader("HospitalList.xls");
        ReadExcel.showExcelData(hospitalList);
        for (int i = 0; i < hospitalList.size(); i++)
        {
            List record = (List) hospitalList.get(i);
            //System.out.println(record);
            //System.out.println(record.get(col));
            name = String.valueOf(record.get(0));
            streetAddress = String.valueOf(record.get(1));
            city = String.valueOf(record.get(2));
            state = String.valueOf(record.get(3));
            zip = String.valueOf(record.get(4));
            latitude = String.valueOf(record.get(5));
            longitude = String.valueOf(record.get(6));
            photo = String.valueOf(record.get(7));

            Hospital hospital = new Hospital(name, streetAddress, city, state, zip, latitude, longitude, phoneNo, photo);
            hospitalBSTree.add(hospital);
        }
        Hospital element = null;
        int treeSize = hospitalBSTree.reset(BinarySearchTree.INORDER);
        System.out.println("The tree in Inorder is:");
        for (int count = 1; count <= treeSize; count++) {
            element = hospitalBSTree.getNext(BinarySearchTree.INORDER);
            System.out.println(element);
        }

    }

}