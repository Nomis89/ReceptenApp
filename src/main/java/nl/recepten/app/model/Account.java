package nl.recepten.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Account {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		
		@OneToOne
		private User user;
		
		@Column(name = "Account")
		private String userName;
		private String passWord;
		private String email;
		
		
		// Getters and setters
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassWord() {
			return passWord;
		}
		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
	
}
