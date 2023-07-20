package kr.ezen.jpademo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Customer {

    @Id
//    @GeneratedValue
    @Column(name = "customer_id")
    private String id;

    private String password;

    private String name;

    private String email;

    private Date inDate;

    private Date upDate;

    // fetch = FetchType.EAGER : 두 엔티티의 정보를 한번에 가져오기(join)
    // fetch = FetchType.LAZY : 필요시에 따로 가져올 때 설정(getList())
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY) // Customer 하나에 여러 게시글
    List<Bbs> list = new ArrayList<>();

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", inDate=" + inDate +
                ", upDate=" + upDate +
                ", list=" + list +
                '}';
    }
}
