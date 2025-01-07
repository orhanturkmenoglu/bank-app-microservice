package org.example.cards.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Schema(
        name = "Accounts",
        description = "Schema to hold Account information")
public class AccountsDto {

    @Schema(
            description = "Account number of the Customer"
    )
    @NotEmpty(message = "Account number can not be a null or empty")
    @Pattern(regexp = "(^$[0-9]{10})", message = "Account number must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account type of the Customer",
            example = "Savings"
    )
    @NotEmpty(message = "Account type can not be a null or empty")
    private String accountType;

    @Schema(
            description = "Branch address of the Customer",
            example = "123 Main Street, New York"
    )
    @NotEmpty(message = "Branch address can not be a null or empty")
    private String branchAddress;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }
}
