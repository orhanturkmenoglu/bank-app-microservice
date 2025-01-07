package org.example.cards.mapper;


import org.example.cards.dto.CardsDetailsDto;
import org.example.cards.dto.CardsDto;
import org.example.cards.dto.CustomerDetailsDto;
import org.example.cards.entity.Cards;

public class CardsMapper {

    public static CardsDto mapToCardsDto(Cards cards, CardsDto cardsDto) {
        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setMobileNumber(cards.getMobileNumber());
        cardsDto.setTotalLimit(cards.getTotalLimit());
        cardsDto.setAvailableAmount(cards.getAvailableAmount());
        cardsDto.setAmountUsed(cards.getAmountUsed());
        return cardsDto;
    }

    public static Cards mapToCards(CardsDto cardsDto, Cards cards) {
        cards.setCardNumber(cardsDto.getCardNumber());
        cards.setCardType(cardsDto.getCardType());
        cards.setMobileNumber(cardsDto.getMobileNumber());
        cards.setTotalLimit(cardsDto.getTotalLimit());
        cards.setAvailableAmount(cardsDto.getAvailableAmount());
        cards.setAmountUsed(cardsDto.getAmountUsed());
        return cards;
    }

    public static CardsDetailsDto mapToCardsDetailsDto(Cards cards, CardsDetailsDto cardsDetailsDto, CustomerDetailsDto customerDetailsDto) {
        cardsDetailsDto.setMobileNumber(cards.getMobileNumber());
        cardsDetailsDto.setCardNumber(cards.getCardNumber());
        cardsDetailsDto.setCardType(cards.getCardType());
        cardsDetailsDto.setTotalLimit(cards.getTotalLimit());
        cardsDetailsDto.setAmountUsed(cards.getAmountUsed());
        cardsDetailsDto.setAvailableAmount(cards.getAvailableAmount());
        cardsDetailsDto.setCustomerDetailsDto(customerDetailsDto);
        return cardsDetailsDto;
    }
}
