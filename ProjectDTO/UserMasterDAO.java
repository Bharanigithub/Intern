package ProjectDTO;

import java.util.List;

public interface UserMasterDAO {
	public int insert(UserDTO user);
	public int update(UserDTO user);
	public int delete(int userno);
	public UserDTO findById(int userno);
	public List<UserDTO> findAll();
}
