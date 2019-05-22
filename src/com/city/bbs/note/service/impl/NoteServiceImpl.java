package com.city.bbs.note.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.city.bbs.note.dao.impl.NoteDaoImpl;
import com.city.bbs.note.factory.DaoFactory;
import com.city.bbs.note.model.NoteModel;
import com.city.bbs.note.service.INoteService;

public class NoteServiceImpl implements INoteService {
	private NoteDaoImpl pdo=null;
	
	public NoteServiceImpl() {
		try {
			this.pdo=(NoteDaoImpl) DaoFactory.createNoteDao();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	@Override
	public List<NoteModel> allOfNotes(int id) {
		return this.pdo.query(id);
	}

	@Override
	public int numOfNotes() {
		return this.pdo.numOfNotes();
	}

	@Override
	public NoteModel oneOfNote(int id) {
		return this.pdo.oneOfNote(id);
	}

	@Override
	public List<NoteModel> allOfReply(int up_id) {
		return this.pdo.queryFromUpId(up_id);
	}

	@Override
	public void addReplyNote(int up_id, String title, String cont, Timestamp time, String user_name) {
		this.pdo.addReplyNote(up_id, title, cont, time, user_name);

	}

	@Override
	public void addModuleNote(int module_id, String title, String cont, Timestamp time, String user_name,
			String m_color) {
		this.pdo.addModuleNote(module_id, title, cont, time, user_name, m_color);

	}

	@Override
	public void deleteFromId(int id) {
		this.pdo.deleteFromId(id);

	}

	@Override
	public List<NoteModel> AllOfTitle(String title) {
		return this.pdo.AllOfTitle(title);

	}

}
