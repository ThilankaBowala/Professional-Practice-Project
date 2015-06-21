/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dahampasala;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Thilanka Bowala <Thilanka Bowala at GIGABYTE>
 */
public class StudentDetails extends AbstractTableModel{
    
    private static final String[] COLUMN_NAMES = {"Reg ID", "First Name", "Last Name", "Gender"};
    private static ArrayList<Student> list;
    
    StudentDetails (ArrayList<Student> stList){
        list = stList;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return COLUMN_NAMES[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return list.get(rowIndex).getRegID();
            case 1: return list.get(rowIndex).getFirstName();
            case 2: return list.get(rowIndex).getLastName();
            case 3: return list.get(rowIndex).getGender();
            default: return "Error";
        }
    }
    
}
