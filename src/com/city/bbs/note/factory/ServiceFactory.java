package com.city.bbs.note.factory;

import com.city.bbs.note.service.INoteService;
import com.city.bbs.note.service.impl.NoteServiceImpl;

public class ServiceFactory {
	public static INoteService createNoteService() {
		return new NoteServiceImpl();
	}
}
