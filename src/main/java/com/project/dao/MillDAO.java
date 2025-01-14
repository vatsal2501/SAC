package com.project.dao;

import java.util.*;
import com.project.model.MillVO;

public interface MillDAO {

	void insertMill(MillVO millVO);
	List<MillVO> searchMill();
	List<MillVO> findById(int id);
}
