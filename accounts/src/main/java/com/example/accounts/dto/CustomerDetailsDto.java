package com.example.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(
        name = "CustomerDetails",
        description = "Schema to hold Customer,Account,Cards and Loans information"
)
public class CustomerDetailsDto {

    @Schema(
            description = "Name of the Customer",
            example = "John Doe"
    )
    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min = 2,max = 30, message = "Name should have at least 2 characters")
    private String name;

    @Schema(
            description = "Email address of the Customer",
            example = "john.doe@example.com"
    )
    @NotEmpty(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be valid value")
    private String email;

    @Schema(
            description = "Mobile number of the Customer",
            example = "1234567890"
    )
    @Pattern(regexp ="(^$|[0-9]{10})", message = "Mobile number should be 10 digits" )
    private String mobileNumber;

    @Schema(
            description = "Accounts of the Customer"
    )
    private AccountsDto accountsDto;


    @Schema(
            description = "Card details of the Customer"
    )
    private CardsDto cardsDto;


    @Schema(
            description = "Loansdetails of the Customer"
    )
    private LoansDto loansDto;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public AccountsDto getAccountsDto() {
        return accountsDto;
    }

    public void setAccountsDto(AccountsDto accountsDto) {
        this.accountsDto = accountsDto;
    }


    /**
     * get field
     *
     * @return loansDto
     */
    public LoansDto getLoansDto() {
        return this.loansDto;
    }

    /**
     * set field
     *
     * @param loansDto
     */
    public void setLoansDto(LoansDto loansDto) {
        this.loansDto = loansDto;
    }

    /**
     * get field
     *
     * @return cardsDto
     */
    public CardsDto getCardsDto() {
        return this.cardsDto;
    }

    /**
     * set field
     *
     * @param cardsDto
     */
    public void setCardsDto(CardsDto cardsDto) {
        this.cardsDto = cardsDto;
    }
}
