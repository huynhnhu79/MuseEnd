package com.example.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.adapter.BangtinAdapter;
import com.example.doan1.ChitietBlog;
import com.example.doan1.R;
import com.example.model.Bangtin;

import java.util.ArrayList;


public class BangTinFragment extends Fragment {
    ListView lvBangtin;
    ArrayList<Bangtin> bangtins;
    BangtinAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bangtin, container, false);
        lvBangtin = view.findViewById(R.id.lvBangtin);
        adapter = new BangtinAdapter(getContext(), R.layout.item_blog,initData());
        lvBangtin.setAdapter(adapter);



        lvBangtin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent= new Intent(getContext(), ChitietBlog.class);
                int hinht = bangtins.get(i).getBangtinThumbnote();
                String mota = bangtins.get(i).getBangtinchitiet();
                String tieude = bangtins.get(i).getBangtintieude();

                intent.putExtra("hinhanhbaiviet",hinht);
                intent.putExtra("tieude",tieude);
                intent.putExtra("mota",mota);
                startActivity(intent);
            }
        });
        return view;
    }

    private ArrayList<Bangtin> initData(){
        bangtins = new ArrayList<>();
        bangtins.add(new Bangtin(R.drawable.sale_off, "Khác với chương trình Muse sale 11.11 chỉ diễn ra ngắn ngày, Muse 12.12 kéo dài đến tận 3 ngày (từ 12/12 – 14/12/2020) để bạn kịp thời gian mua hết những gì đã bỏ lỡ ở đợt khuyến mãi trước. Lịch trình cụ thể bao gồm:\n" +
                "•\tTừ 04.12 – 11.12.2020: Giai đoạn Teasing. Đây là giai đoạn chuẩn bị cho ngày siêu sale, bạn nên tìm hiểu các thông tin khuyến mãi, sưu tầm sẵn voucher, bỏ sản phẩm vào giỏ hàng để chuẩn săn sale.\n" +
                "•\tTừ 12.12 – 14.12.2020: Giai đoạn D-day. Đây là 03 ngày bùng nổ diễn ra chương trình khuyến mãi Muse 12.12", "CHƯƠNG TRÌNH ƯU ĐÃI 12.12", R.drawable.sale_off_im));
        bangtins.add(new Bangtin(R.drawable.christmas, "Lại một mùa Giáng sinh và Năm mới nữa đến. Tuy đây không phải dịp lễ truyền thống của dân tộc, nhưng với xu thế toàn cầu hóa hiện nay, Giáng sinh và Năm mới cũng được rất nhiều người hưởng ứng, nhất là giới trẻ. Chắc hẳn rất nhiều tín đồ mua sắm đang mong chờ một đợt khuyến mãi cuối cùng để \"chốt hạ\" trước khi bước sang năm mới. Dịp này, nhiều chương trình khuyến mãi lên đến trên 90% được rất nhiều sàn thương mại điện tử lớn tung ra. Hơn nữa, Giáng sinh thì không thể thiếu quà tặng, vậy nên cùng với giảm giá, nhân dịp này Muse sẽ tặng bạn các voucher cũng như các chương trình ưu đãi hấp dẫn. Ngay từ bây giờ Muse đã bắt đầu chiến dịch Giáng Sinh & Năm mới của mình, nhanh tay lựa ngay những món đồ ưng ý cho một mùa lễ hội thật ấm áp nhé!",  "KHUYẾN MÃI GIÁNG SINH",  R.drawable.christmas_im));
        bangtins.add(new Bangtin(R.drawable.mixandmatch, "Là con gái ai cũng muốn trở nên xinh đẹp và dễ thương trong mắt của mọi người. Để tận dụng lợi thế của trang phục là một trong những cách giúp cho chúng ta có thể khoe được vẻ đẹp đáng yêu và trong sáng.Bài viết xin chia sẻ 10 cách phối đồ đẹp cho nữ.\n" +
                " Áo thun rộng, quần short jean, tất thể thao dài, giày thể thao, balo\n" +
                "Những cách phối đồ đẹp cho nữ mà bạn không nên bỏ qua đó là item kết hợp giữa áo thun rộng và quần short jean. Đây là sự kết hợp được cho là không bao giờ lỗi mốt, nó giúp cho bạn khoe được vẻ đẹp trẻ trung và năng động. Phong cách này hoàn toàn phù hợp với những bạn học sinh sinh viên hoặc những bạn muốn diện phong cách này để đi chơi. Ngoài ra để tạo điểm nhấn cho set đồ này bạn có thể kết hợp thêm tất thể thao dạng dài và balo.\n" +
                "Cách phối đồ đơn giản mà đẹp cho nữ không thể bỏ qua được set đồ vừa kể trên. Đây là một trong những phương pháp kết hợp quần áo cũng khá phổ biến. Thay vì sử dụng quần short thì các chị em phụ nữ có thể thay thế bằng váy ngắn hoặc váy xếp ly ngắn.\n" +
                "Áo thun, chân váy xòe, giày thể thao và áo khoác jean\n" +
                "Cách phối đồ đẹp cho nữ theo công thức này đó là sự biến tấu của công thức thứ hai. Chỉ cần kết hợp thêm một chiếc áo jean bên ngoài là bạn sẽ trở nên cá tính hơn bao giờ hết.\n" +
                "Tùy theo sở thích của bạn mà có thể lựa chọn chiếc áo khoác có kích cỡ vừa sẽ rất giản dị và đáng yêu. Còn nếu muốn thời trang và phá cách hơn thì có thể chọn những chiếc áo khoác jean theo phong cách oversize.\n" +
                "Áo voan xòe, quần short, túi xách vừa, xăng đan\n" +
                "Những cách phối đồ đẹp cho nữ mà bạn có thể hướng đến nếu muốn đi chơi hoặc đi biển thì công thức này là hoàn toàn phù hợp. Một chiếc áo được may từ chất liệu voan có phần gấu áo may dáng xòe, kết hợp với quần short sẽ giúp cho bạn khéo léo khoe được đôi chân dài của mình.\n" +
                "Ngoài ra để tăng thêm sự hứng thú cho set đồ này bạn có thể kết hợp cùng giày sandal và một túi xách có kích cỡ dạng vừa.\n" +
                " Áo thun rộng, chân váy ôm, giày thể thao\n" +
                "Trong cách phối đồ đơn giản mà đẹp cho nữ theo xu hướng Hàn Quốc thì thay vì lựa chọn các loại chân váy xòe thì người ta lại chọn những loại chân váy có dáng ôm. Chân váy dáng ôm kết hợp với áo thun rộng và giày thể thao cũng được xem là một trong những item thời trang có thể giúp cho bạn khoe được vẻ đẹp đáng yêu và dịu dàng.Set đồ này để tránh tình trạng bị luộm thuộm, cách tốt nhất đó chính là nên bỏ áo vào thùng. Sự kết hợp này có thể giúp cho bạn có thể vừa đi làm vừa đi chơi.\n",  "CÁCH PHỐI ĐỒ ĐẸP",  R.drawable.mixandmatch_im));
        bangtins.add(new Bangtin(R.drawable.collection, "Năm 2009 đánh dấu lần đầu tiên Uniqlo hợp tác nhà thiết kế (NTK) Jil Sander. Bộ sưu tập (BST) +J thu đông 2021 là cột mốc đặc biệt, khép lại chương 2 trong hành trình hợp tác giữa thương hiệu bán lẻ thời trang toàn cầu đến từ Nhật Bản với NTK người Đức này.\n" +
                "Chương đầu tiên của hành trình hợp tác được giới thiệu cách đây 12 năm, với sự ra mắt của các BST từ 2009 đến 2011. Chương 2 gồm BST +J qua các mùa thu đông 2020, xuân hè 2021 và mới nhất là thu đông 2021.\n" +
                "BST +J thu đông 2021 giữ nguyên dấu ấn của phong cách thiết kế đặc trưng và cảm hứng tinh tế, tĩnh tại. Những đường may tinh xảo kết hợp chất liệu vải cao cấp mang đến một hình thái hiện đại, tươi mới hơn và bổ sung nhiều tính năng mới cho các thiết kế trang phục thiết yếu.\n" +
                "BST giới thiệu các thiết kế nổi bật với phom dáng rộng, thoải mái nhưng vẫn đầy phong cách. Phom dáng với hiệu ứng như điêu khắc độc đáo và tỷ lệ cân đối hứa hẹn mang đến cảm giác thoải mái, nhẹ nhàng cho người mặc. BST +J tiếp tục định hình phong cách thời trang hiện đại, truyền cảm hứng với nguồn năng lượng tích cực và sự tự tin để hòa mình vào nhịp sống mới.\n" +
                "NTK Jil Sander chia sẻ: \"Khi trở lại nhịp sống mới, chúng ta đều mong muốn một cảm giác an toàn và được bảo vệ. Bên cạnh các mẫu trang phục không thể thiếu của mùa đông, BST lần này mang đến những khám phá mới trong phom dáng ngoại cỡ, được tính toán về thiết kế để cân bằng với cảm giác vừa vặn của người mặc, phù hợp nhiều hoàn cảnh\".\n" +
                "BST +J thu đông 2021 mang đến hình thái mới, hiện đại, tinh xảo và sang trọng hơn cho những trang phục mùa đông kinh điển. Sắc trắng và gam màu đỏ với các sắc độ khác nhau mang đến điểm nhấn đầy năng lượng cho tổng thể BST, gồm các tông đen, than, kaki và caramel. Các thiết kế được tạo nên từ nhiều chất liệu như techno-satin, cashmere đến len merino siêu mịn, da và lụa tơ tằm habotai. Mỗi chi tiết của BST đều chứa đựng sự chăm chút, cải tiến hòa cùng cảm hứng thanh lịch, tinh tế đương đại.\n" +
                "\n",  "RA MẮT BỘ SƯU TẬP 2021",  R.drawable.collection_im));
        bangtins.add(new Bangtin(R.drawable.beauty, "Làm đẹp da mặt bằng nước vo gạo \n" +
                "Trong nước vo gạo chứa nhiều vitamin B giúp làm mềm trắng da và se khít lỗ chân lông. Bên cạnh đó tinh bột cám gạo còn giúp bạn trị mụn, làm mờ vết thâm và chống lão hóa tại nhà. \n" +
                "Cách làm đẹp da mặt bằng nước vo gạo bạn thực hiện như sau. Lấy gạo vo 1 lần qua nước đầu đổ đi rồi cho nước vừa đủ và vo lần 2. Sau đó bạn chắt nước gạo vào 1 cái tô rồi để khoảng 4-5 tiếng cho tinh bột lắng xuống. Bạn nhẹ nhàng đổ phần nước trong đi rồi lấy phần tinh bột gạo thu được mát xa da mặt rồi rửa với nước sạch. \n" +
                "Làm đẹp da mặt sau sinh bằng nghệ \n" +
                "Trong củ nghệ tươi chứa nhiều Cucurmin giúp chống oxy hóa, trị mụn, làm mờ vết thâm và làm da trắng lên hiệu quả. Ăn nghệ không chỉ giúp đẹp da mà còn chữa được khá nhiều bệnh liên quan đến dạ dày hệ tiêu hóa. \n" +
                "Cách làm đẹp da mặt bằng nghệ: Bạn lấy củ nghệ giã thật nhuyễn mịn rồi trộn với mật ong đắp lên mặt khoảng 15-20 phút rồi rửa lại với nước sạch. Bạn nên thực hiện 2-3 lần/tuần để có kết quả tốt. \n" +
                "Làm đẹp da bằng mật ong \n" +
                "Mật ong là một trong những nguyên liệu không chỉ tốt với sức khỏe mà còn được mệnh danh là thần dược làm đẹp da. Trong mật ong chứa nhiều Vitamin A, E, C, B và một số khoáng chất như sắt, kẽm, canxi, đồng… tốt với làn da và sức khỏe. Bên cạnh đó hàm lượng chất chống oxy hóa giúp bảo vệ da khỏi các tác nhân bên ngoài giúp ngăn ngừa lão hóa và duy trì sự tươi trẻ. \n" +
                "Để thực hiện bạn lấy 2 mật ong nguyên chất hòa trộn ½ thìa nước cốt chanh được hỗn hợp bôi lên mặt trong 20 phút rồi rửa lại với nước sạch. Kiên trì thực hiện 2 lần/tuần vào mỗi tối để có kết quả tốt nhất. \n" +
                "Làm đẹp da mặt bằng dầu dừa \n" +
                "Dầu dừa chứa nhiều thành phần tốt với làn da như vitamin C, E … giúp kích thích sản sinh collagen tăng đàn hồi cho da tóc và móng đồng thời ngăn ngừa đẩy lùi lão hóa chảy xệ da. Bên cạnh đó các thành phần kháng khuẩn cũng giúp ngăn ngừa mụn giảm đau chống viêm cũng như chống nấm.\n" +
                "Cách thực hiện làm đẹp da mặt bằng dầu dừa: Bạn lấy lượng dầu dừa nhỏ thoa lên vùng da mặt đã làm sạch mát xa theo hình tròn từ dưới lên trên và từ trước mặt ra phía tai khoảng 3 phút rồi đi ngủ sáng ra rửa lại mặt. Thường xuyên làm đẹp da bằng dầu dừa giúp da sáng mịn, trẻ hóa và trị mụn hiệu quả.\n" +
                "Làm đẹp da mặt bằng mồng tơi \n" +
                "Rau mồng tơi chứa nhiều vitamin A, C, B, Canxi,,,, giúp làm da trắng sáng mịn màng. Khi sử dụng mặt nạ từ rau mồng tơi giúp điều trị mụn trứng cá, làm da trắng sáng mịn màng hiệu quả nhất. \n" +
                "Để thực hiện bạn lấy nắm lá mồng tơi rửa sạch xay nhuyễn được hỗn hợp. Bạn lấy hỗn hợp này đắp lên vùng da mặt đã làm sạch để trong khoảng 10-15 phút rồi rửa lại với nước mát. Thực hiện đều đặn 2-3 lần/tuần để có kết quả tốt nhất. \n" +
                "Làm đẹp da mặt bằng nha đam \n" +
                "Nha đam ngoài việc làm thanh mát giải nhiệt cơ thể mà còn chứa nhiều khoáng chất giúp làm đẹp da giảm mụn nhọt và se khít lỗ chân lông. \n" +
                "Để thực hiện bạn lấy lá nha đam gọt vỏ rửa sạch sau đó thái miếng nhỏ cho vào nồi đun sôi đến khi nước đặc lại. Bạn lấy phần nước cô đặc hòa với mật ong rồi thoa lên hỗn hợp lên mặt từ 15-20 phút rồi rửa lại với nước mát. Thực hiện 2-3 lần/tuần để có kết quả tốt nhất. \n" +
                "Làm đẹp da mặt bằng sữa chua \n" +
                "Trong sữa chua không đường chứa đầy đủ các khoáng chất thiết yếu như canxi, vitamin A, C, E … giúp làm suy yếu cấu trúc hắc tố melanin. Bên cạnh đó còn cung cấp dưỡng chất giúp cân bằng độ ẩm và khắc phục hoàn hảo nhược điểm da khô thiếu nước hồi sinh da đen sạm. \n" +
                "Để thực hiện bạn lấy 2 thìa sữa chua không đường hòa trộn với 1 thìa mật ong được hỗn hợp. Dùng hỗn hợp này bôi lên vùng da đã làm sạch để trong khoảng 15-20 phút rồi rửa lại với nước mát. Thực hiện đều đặn 2-3 lần/tuần để có kết quả tốt nhất. \n" +
                " Làm đẹp da mặt bằng trứng gà \n" +
                "Trong chứa gà chứa nhiều vitamin A, C, E và các khoáng chất giúp làm đẹp da an toàn hiệu quả. Đặc biệt hàm lượng Enzyme Lysozyme giúp tiêu diệt vi khuẩn dưới da, làm se khít lỗ chân lông, ngừa mụn và làm trắng da.\n" +
                "Cách thực hiện: Bạn lấy 1 quả trứng gà và 1 thìa mật ong trộn đều được hỗn hợp. Lấy hỗn hợp này đắp lên mặt khoảng 15-20 phút rồi rửa lại với nước mát. Thực hiện đều đặn 2-3 lần/tuần để da sáng mịn màng tự nhiên nhất. \n" +
                "\n",  "CÁC MẸO LÀM ĐẸP",  R.drawable.beauty_im));



        return bangtins;
    }
}