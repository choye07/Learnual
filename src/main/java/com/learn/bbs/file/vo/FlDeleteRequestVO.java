package com.learn.bbs.file.vo;

public class FlDeleteRequestVO {
	
	// 게시글의 아이디 (맵퍼에서 쓰기 위해서)
		private String id;
		
		// 파일의 아이디
		private String flId;
		
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getFlId() {
			return flId;
		}

		public void setFlId(String flId) {
			this.flId = flId;
		}
		
}
