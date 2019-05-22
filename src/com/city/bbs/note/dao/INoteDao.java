package com.city.bbs.note.dao;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.city.bbs.note.model.NoteModel;

public interface INoteDao {
	/*根据版块号id查询所有note信息*/
	List<NoteModel> query(int id);
    
    /*返回所有帖子的数量*/
    int numOfNotes();
    
    NoteModel oneOfNote(int id);
    List<NoteModel> queryFromUpId(int up_id);
    void addReplyNote(int up_id,String title,String cont,Timestamp time,String user_name);
    
    void addModuleNote(int module_id,String title,String cont,Timestamp time,String user_name,String m_color);
    void deleteFromId(int id);
    List<NoteModel> AllOfTitle(String title);
}
