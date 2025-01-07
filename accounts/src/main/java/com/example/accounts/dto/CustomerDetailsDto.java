package com.example.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(
        name = "CustomerDetails",
        description = "Schema to hold Customer,Account,Cards and Loans information"
)
@Data
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

}
