package br.com.ferramentaria.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDto {

	private String message;
	
	public MessageResponseDto(String message) {
		this.message = message;
	}

	public static MessageResponseDto message(String message) {
		return new MessageResponseDto(message);
	}

}
