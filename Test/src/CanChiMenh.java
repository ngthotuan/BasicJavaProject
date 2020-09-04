import java.text.ParseException;
import java.util.Calendar;
import java.util.Scanner;

public class CanChiMenh {
    private static String getYearInfo(int year){
        String can[] = {"Canh","Tân","Nhâm","Quý","Giáp","Ất","Bính","Đinh","Mậu","Kỷ"};
        String chi[] = {"Tý","Sửu","Dần","Mão","Thìn","Tỵ","Ngọ","Mùi","Thân","Dậu","Tuất","Hợi"};
        int cscan[] = {4,4,5,5,1,1,2,2,3,3};
        int cschi[] = {0,0,1,1,2,2,0,0,1,1,2,2};
        String menh[] = {"Kim","Thủy","Hỏa","Thổ","Mộc"};


        int canValue = year%10;
        int chiValue = year%100%12;
        int menhValue = cscan[canValue] + cschi[chiValue];
        menhValue--;
        if(menhValue > 5) menhValue -=5;

        StringBuilder builder = new StringBuilder();
        builder.append("Sinh năm: ")
                .append(can[canValue])
                .append(" ")
                .append(chi[chiValue])
                .append("\nMệnh: ")
                .append(menh[menhValue])
                .append("\nTuổi: ")
                .append(Calendar.getInstance().get(Calendar.YEAR) - year);

        return builder.toString();
    }

    public static void main(String []args){
        try {
            System.out.print("Nhập năm sinh của bạn: ");
            int year = Integer.parseInt(new Scanner(System.in).nextLine());
            System.out.println(getYearInfo(year));

        } catch (Exception e){
            System.err.println("Năm sinh không hợp lệ!!!!");
        }
    }
}
