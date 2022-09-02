package com.project.products.config.validacao;

public class FormsErrorDto {
	
	private String campo;
	private String erro;
	
	public FormsErrorDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
}
