package com.learn.bbs.eduad.todo.vo;

import com.learn.io.github.seccoding.excel.annotations.ExcelSheet;
import com.learn.io.github.seccoding.excel.annotations.Field;

//@ExcelSheet(startRow = 1)
@ExcelSheet(startRow = 1)
public class ReadExceTodoFile {
	// 엑셀파일의 첫번째 시트에서 1 번째 row부터 읽는다. (컬럼명 row=1 부터 시작)

		// 엑셀 시트에서 A컬럼 내용만 읽는다.
		@Field("A")
		private String no;

		// 엑셀 시트에서 E컬럼 내용만 읽는다.
		// E컬럼의 타입이 날짜 타입이므로 isDate 적용.
		@Field(value = "B", isDate = true)
		private String date;

		// 엑셀 시트에서 E컬럼 내용만 읽는다.
		@Field("E")
		private String subject;

		// 엑셀 시트에서 F컬럼 내용만 읽는다.
		@Field("F")
		private String content;

		// 엑셀 시트에서 G컬럼 내용만 읽는다.
		@Field("G")
		private String instrName;

		// 엑셀 시트에서 H컬럼 내용만 읽는다.
		@Field("H")
		private String classroom;

		public String getNo() {
			return no;
		}

		public void setNo(String no) {
			this.no = no;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getInstrName() {
			return instrName;
		}

		public void setInstrName(String instrName) {
			this.instrName = instrName;
		}

		public String getClassroom() {
			return classroom;
		}

		public void setClassroom(String classroom) {
			this.classroom = classroom;
		}
}
