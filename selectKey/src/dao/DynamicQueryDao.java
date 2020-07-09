package dao;

import java.util.HashMap;
import java.util.List;

import dto.SelectKey;

public interface DynamicQueryDao {

	public List<HashMap<String, Object>> select();

	public List select2(String id);

	public List select3(SelectKey selectKey);

}
