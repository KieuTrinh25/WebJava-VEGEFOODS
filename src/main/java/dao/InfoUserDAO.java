package dao;

import java.util.List;

import model.InfoUser;



public interface InfoUserDAO {
	public boolean insert(InfoUser infoUser);
    public boolean update(InfoUser infoUser);
    public boolean delete(int infoUserId);
    
    public List<InfoUser> all();
    
}
