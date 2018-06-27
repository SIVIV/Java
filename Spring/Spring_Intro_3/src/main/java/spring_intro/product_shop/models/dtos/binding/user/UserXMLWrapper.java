package spring_intro.product_shop.models.dtos.binding.user;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class UserXMLWrapper {
    @XmlElement(name = "user")
    private List<UserBindingModelX> users;

    public List<UserBindingModelX> getUsers() {
        return this.users;
    }

    public void setUsers(List<UserBindingModelX> users) {
        this.users = users;
    }
}
