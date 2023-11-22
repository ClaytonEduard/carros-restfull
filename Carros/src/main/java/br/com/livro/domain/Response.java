/*
* Copyright
*22-11-2023
* Clayton Eduard
* Github - https://github.com/ClaytonEduard
*
*/

package br.com.livro.domain;

public class Response {
	private String status;
	private String msg;

	public Response() {

	}

	public static Response OK(String string) {
		Response r = new Response();
		r.setStatus("Ok");
		r.setMsg(string);
		return r;
	}

	public static Response Error(String string) {
		Response r = new Response();
		r.setStatus("ERROR");
		r.setMsg(string);
		return r;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
