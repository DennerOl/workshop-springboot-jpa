package com.educandoweb.curso.entities.enums;

public enum OrderStatus {

	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGE(4),
	CANCELADO(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
/* vou passar um codigo e esse metodo vai me retornar
 * de acordo com codigo o orderStatus 	
 */
	public static OrderStatus valueOf(int code) {
// percorro todos valores do enu e verifico se é igual ao code		
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código invalido");
	}
	
}
