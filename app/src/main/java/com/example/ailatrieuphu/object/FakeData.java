package com.example.ailatrieuphu.object;

import androidx.appcompat.app.AlertDialog;

import com.example.ailatrieuphu.MainActivity2;
import com.example.ailatrieuphu.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FakeData {

//    public FaceData() {
//        addDataCauHoi();
//    }
    ArrayList<ArrayList<CauHoi>> arrCauHoi = new ArrayList<>();

//    public ArrayList<ArrayList<CauHoi>> getArrCauHoi() {
//        return arrCauHoi;
//    }


    public CauHoi taoCauHoi(int capDo) {//cấp độ sẽ = vị trí câu hỏi
        Random r = new Random();
        ArrayList<CauHoi> arr = arrCauHoi.get(capDo - 1);
        return arr.get(r.nextInt(arr.size()));

    }

    public void addDataCauHoi() {
        // câu 1
        ArrayList<CauHoi> arrCauSo1 = new ArrayList<>();

        arrCauSo1.add(khoiTaoCauHoi("Kiev là thủ đô của nước nào ?",
                "Ukraine", "Nga&Pháp&Mỹ"));
        arrCauSo1.add(khoiTaoCauHoi("Đâu là tên thủ đô của nước Việt Nam ?",
                "Hà Nội",
                "Thái Nguyên" + "&" + "Hà Nam" + "&"+ "Hồ Chí Minh"));
        // arrCauSo1.add(taoCauHoi("","",""));
        arrCauHoi.add(arrCauSo1);

        ///cau so 2
        ArrayList<CauHoi> arrCauSo2 = new ArrayList<>();
        arrCauSo2.add(khoiTaoCauHoi("Vladimir Vladimirovich Putin là Tổng Thống của nước nào?",
                "Nga", "Anh&Pháp&Mỹ"));
        arrCauSo2.add(khoiTaoCauHoi("Đâu là tên của cựu Tổng Thống Mỹ?",
                "Barack Obama",
                "Nguyễn Huy Quang" + "&" + "Nguyễn Phú Trọng" + "&"+ "Ralf Rangnick"));
        arrCauHoi.add(arrCauSo2);

        ///cau so 3
        ArrayList<CauHoi> arrCauSo3 = new ArrayList<>();
        arrCauSo3.add(khoiTaoCauHoi("Đâu là một loại hình chợ tạm tự phát thường xuất hiện trong các khu dân cư?",
                "Cóc", "Ếch" + "&" + "Thằn lằn" + "&"+ "Nhái"));
        arrCauSo3.add(khoiTaoCauHoi("Đâu là tên viết tắt của trường ĐH CNTT & TT Thái Nguyên ?",
                "ICTU", "SFL&TNUT&TUMP"));
        arrCauHoi.add(arrCauSo3);

        // câu 4
        ArrayList<CauHoi> arrCauSo4 = new ArrayList<>();
        arrCauSo4.add(khoiTaoCauHoi("Mưa ngâu là vào khoảng tháng mấy trong năm?", "7", "1&4&6"));
        arrCauSo4.add(khoiTaoCauHoi("Điền từ còn thiếu vào câu sau: \"Nhập gia...\"thì làm sao ?",
                "Tuỳ tục",
                "Tuỳ tâm&Tuỳ cảnh&Tuỳ người"));
        arrCauHoi.add(arrCauSo4);

        // câu 5
        ArrayList<CauHoi> arrCauSo5 = new ArrayList<>();
        arrCauSo5.add(khoiTaoCauHoi("Cristiano Ronaldo là cầu thủ nước nào?",
                "Bồ Đào Nha", "Anh" + "&" + "Pháp" + "&"+ "Argentina "));
        arrCauSo5.add(khoiTaoCauHoi("Premier League là tên giải bóng đá nước nào?",
                "Anh", "Argentina" + "&" + "Pháp" + "&"+ " Bồ Đào Nha"));
        arrCauHoi.add(arrCauSo5);

        // câu 6
        ArrayList<CauHoi> arrCauSo6 = new ArrayList<>();
        arrCauSo6.add(khoiTaoCauHoi("Haiku là thể thơ truyền thống của nước nào ?",
                "Nhật Bản", "Mông Cổ" + "&" + "Hàn Quốc" + "&"+ "Trung Quốc"));
        arrCauSo6.add(khoiTaoCauHoi("Chùa Tam chúc nằm trên địa phận tỉnh nào của nước ta ?",
                "Hà Nam", "Thái Nguyên" + "&" + "Đà nẵng" + "&"+ "Hà Nội"));
        arrCauHoi.add(arrCauSo6);

        // câu 7
        ArrayList<CauHoi> arrCauSo7 = new ArrayList<>();
        arrCauSo7.add(khoiTaoCauHoi("Đâu là tên một bãi biển ở Quảng Bình?",
                "Đá Nhảy", "Đá Bò" + "&" + "Đá Chạy" + "&"+ " Đá Lăn"));
        arrCauSo7.add(khoiTaoCauHoi("Pha màu đỏ với màu xanh lam, ta được màu nào sau đây?",
                "Tím", "Vàng&Xanh&Nâu"));
        // arrCauSo1.add(taoCauHoi("","",""));
        arrCauHoi.add(arrCauSo7);

        // câu 8
        ArrayList<CauHoi> arrCauSo8 = new ArrayList<>();
        arrCauSo8.add(khoiTaoCauHoi("Điền từ còn thiếu vào câu sau: \"Mạnh vì...,bạo vì tiền ?\"",
                "Gạo", "Nước&Vàng&Khoẻ"));
        arrCauSo8.add(khoiTaoCauHoi("Theo một câu hát: “Ba thương con vì con giống mẹ. \"Mẹ thương con vì con giống...” ai?\"",
                "Ba", "Chú cạnh nhà&Bác đầu ngõ&Ông hàng xóm"));
        arrCauHoi.add(arrCauSo8);

        // câu 9
        ArrayList<CauHoi> arrCauSo9 = new ArrayList<>();
        arrCauSo9.add(khoiTaoCauHoi("Đường vô xứ... quanh quanh.\" Non xanh nước biếc như tranh họa đồ ?\"",
                "Huế", "Thanh&Nghệ&Đoài"));
        arrCauSo9.add(khoiTaoCauHoi("Câu lạc bộ bóng đá nào của nước Anh có biểu tượng là chú gà chọi?",
                "Tottenham ", "Leicester City&Everton&Manchester United"));
        // arrCauSo1.add(taoCauHoi("","",""));
        arrCauHoi.add(arrCauSo9);

        // câu số 10
        ArrayList<CauHoi> arrCauSo10 = new ArrayList<>();
        arrCauSo10.add(khoiTaoCauHoi("Đâu là một sáng tác của Sơn Tùng M-TP?",
                "Nơi này Có Anh", "Nơi này Có Chị&Nơi này Có Chú&Nơi này Có Thím"));
        arrCauSo10.add(khoiTaoCauHoi("Đâu là tên 1 loại mũ?",
                "Lưỡi Trai ", "Lưỡi Hái&Lưỡi Lê&Lưỡi rắn"));
        arrCauHoi.add(arrCauSo10);

        // câu số 11
        ArrayList<CauHoi> arrCauSo11 = new ArrayList<>();
        arrCauSo11.add(khoiTaoCauHoi("El Niño là gì?",
                "Một hiện tượng thời tiết", "Một hiện tượng mạng&Một loài cây&Một điệu nhảy"));
        arrCauSo11.add(khoiTaoCauHoi("Đâu là tên 1 ban nhạc Rock ?",
                "Bức tường", "Bức tranh&Bức tượng&Bức thư"));
        arrCauHoi.add(arrCauSo11);

        // câu 12
        ArrayList<CauHoi> arrCauSo12 = new ArrayList<>();
        arrCauSo12.add(khoiTaoCauHoi("Việt nam thuộc châu lục nào ?",
                "Châu Á", "Châu Mỹ&Châu Âu&Châu Đại Dương"));
        arrCauSo12.add(khoiTaoCauHoi("Nhất quỷ, nhì ma, thứ ba...?",
                "Học Trò", "Học Viên&Giáo Viên&Bảo Vệ"));
        arrCauHoi.add(arrCauSo12);

        // câu 13
        ArrayList<CauHoi> arrCauSo13 = new ArrayList<>();
        arrCauSo13.add(khoiTaoCauHoi("Ấu trùng của muỗi được gọi là gì?",
                "Bọ gậy", "Bọ xít&Bọ chét&Bọ hung"));
        arrCauSo13.add(khoiTaoCauHoi("Đâu là tên 1 loại giấy tờ tuỳ thân ?",
                "Căn Cước", "Căn cứ&Căn bậc 2&Căn dặn"));
        arrCauHoi.add(arrCauSo13);

        // câu 14
        ArrayList<CauHoi> arrCauSo14 = new ArrayList<>();
        arrCauSo14.add(khoiTaoCauHoi("Bộ phận nào trên gương mặt là cơ quan khứu giác?",
                "Mũi", "Mắt&Tai&Lưỡi"));
        arrCauSo14.add(khoiTaoCauHoi("Các website có đuôi .vn là tên miền Internet của nước nào  ?",
                "Việt Nam", "Lào&Campuchia&Thái Lan"));
        arrCauHoi.add(arrCauSo14);

        // câu 15
        ArrayList<CauHoi> arrCauSo15 = new ArrayList<>();
        arrCauSo15.add(khoiTaoCauHoi("Cấp học dành cho trẻ em dưới 6 tuổi gọi là gì?",
                "Mẫu giáo", "Tiểu học&Trung học&Phổ thông"));
        arrCauSo15.add(khoiTaoCauHoi("Cần bao nhiêu tờ 2k để đổi tờ 10k ?", "5", "2&10&20"));
        arrCauHoi.add(arrCauSo15);
    }

    private CauHoi khoiTaoCauHoi(String s1, String s2, String s3) {
        CauHoi c1 = new CauHoi();
        c1.setNoiDung(s1);
        c1.setDapAnDung(s2);
        c1.setArrDapAnSai(s3);
        c1.getDapAnDung();
        return c1;
    }

}
