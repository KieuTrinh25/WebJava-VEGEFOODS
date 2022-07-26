package dao;

import java.util.List;
import model.InfoUser;

public interface InfoUserDAO {
	public boolean insert(InfoUser infoUser);
    public boolean update(InfoUser infoUser);
    public boolean delete(int infoUserId);
    
    public List<InfoUser> all();
    public InfoUser find(int id);
    public List<InfoUser> findByProperty(String column, Object value);

}
