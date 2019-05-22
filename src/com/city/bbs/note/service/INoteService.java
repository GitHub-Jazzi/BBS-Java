package com.city.bbs.note.service;

import java.sql.Timestamp;
import java.util.List;

import com.city.bbs.note.model.NoteModel;

public interface INoteService {
	List<NoteModel> allOfNotes(int id);
    int numOfNotes();
    /*ÊÇnoteµÄidºÅ*/
    NoteModel oneOfNote(int id);
    
    List<NoteModel> allOfReply(int up_id);
    
    void addReplyNote(int up_id,String title,String cont,Timestamp time,String user_name);
    
    void addModuleNote(int module_id,String title,String cont,Timestamp time,String user_name,String m_color);
    void deleteFromId(int id);
    List<NoteModel> AllOfTitle(String title);
}
