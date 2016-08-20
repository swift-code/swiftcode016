package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
/**
 * Created by lubuntu on 8/20/16.
 */
public class User extends Model
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String email;
    public String password;

    @OneToMany(mappedBy = "sender")
    public List<ConnectionRequest> connectionRequestSent;

    @OneToMany(mappedBy = "receiver")
    public List<ConnectionRequest> connectionRequestReceived;

    @OneToOne
    public Profile profile;

    @ManyToMany
    @JoinTable(name = "user_connections",
            joinColumns = {
                    @JoinColumn(name = "user_id")
            }
            , inverseJoinColumns = {
                    @JoinColumn(name = "Connection_id")
            }
    )
    public Set<User> connections;

}
