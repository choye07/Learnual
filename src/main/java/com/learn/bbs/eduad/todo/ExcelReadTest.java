package com.learn.bbs.eduad.todo;
import java.io.File;
import java.util.List;
import java.util.Map;

import com.learn.io.github.seccoding.excel.annotations.ExcelSheet;
import com.learn.io.github.seccoding.excel.annotations.Field;
import com.learn.io.github.seccoding.excel.read.Read;

public class ExcelReadTest {

	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\ypstm\\Downloads", "강의계획서.xlsx");
		
		// 파일의 위치가 있는 클래스를 읽는다.
		Read<TestClass> read = new Read<>(file.toPath(), TestClass.class);
		List<TestClass> result1 = read.read();
		result1.forEach(tc -> {
			System.out.println(tc.getColumnName());
			System.out.println(tc.getNo());
			System.out.println(tc.getType());
		});
		
		// 엑셀의 몇행부터(컬럼명 포함) 읽는지 지정해준다.
		List<TestClass> result2 = read.read("testsheet", 3);
		result2.forEach(tc -> {
			System.out.println(tc.getColumnName()); // 컬럼명
			System.out.println(tc.getNo()); // 순번
			System.out.println(tc.getType()); // 타입을 읽는다.
		});
		
		
		Map<String, List<TestClass>> resultMap = read.readToMap();
		resultMap.entrySet().forEach(tc -> {
			System.out.println(tc.getKey());
			System.out.println(tc.getValue());
		});
		
		Map<String, List<TestClass>> resultMap2 = read.readToMap(Map.of("testsheet", 1));
		resultMap2.entrySet().forEach(tc -> {
			System.out.println(tc.getKey());
			System.out.println(tc.getValue());
		});
	}

	// 엑셀파일의 첫번째 시트에서 1 번째 row부터 읽는다. (컬럼명 필요)
	@ExcelSheet(startRow=1)
	public static class TestClass {

		// 엑셀 시트에서 A컬럼 내용만 읽는다.
		@Field("A")
		private String no;

		// 엑셀 시트에서 F컬럼 내용만 읽는다. - 강의 내용
		@Field("F")
		private String columnName;

		// 엑셀 시트에서 E컬럼 내용만 읽는다.
		// E컬럼의 타입이 날짜 타입이므로 isDate 적용.
		@Field(value="B")
		private String type;

		public String getNo() {
			return no;
		}

		public void setNo(String no) {
			this.no = no;
		}

		public String getColumnName() {
			return columnName;
		}

		public void setColumnName(String columnName) {
			this.columnName = columnName;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

	}

}