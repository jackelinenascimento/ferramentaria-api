package br.com.ferramentaria.api.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageResponseDto {

	private String message;
	
	public MessageResponseDto(String message) {
		this.message = message;
	}

	public static MessageResponseDto message(String message) {
		return new MessageResponseDto(message);
	}

}
