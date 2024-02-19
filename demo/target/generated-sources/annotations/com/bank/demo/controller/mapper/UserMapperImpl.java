package com.bank.demo.controller.mapper;

import com.bank.demo.controller.dto.AccountDTO;
import com.bank.demo.controller.dto.AccountTransactionDTO;
import com.bank.demo.controller.dto.ReceiveDTO;
import com.bank.demo.controller.dto.TransactionPostDTO;
import com.bank.demo.controller.dto.TransmitDTO;
import com.bank.demo.controller.dto.UserDTO;
import com.bank.demo.entity.Account;
import com.bank.demo.entity.Transaction;
import com.bank.demo.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-19T17:52:05+0200",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setAccounts( accountListToAccountDTOList( entity.getAccounts() ) );
        userDTO.setFullName( entity.getFullName() );
        userDTO.setNationalId( entity.getNationalId() );
        userDTO.setPhone( entity.getPhone() );

        return userDTO;
    }

    @Override
    public User toUser(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setFullName( dto.getFullName() );
        user.setNationalId( dto.getNationalId() );
        user.setPhone( dto.getPhone() );

        return user;
    }

    @Override
    public AccountDTO toDto(Account entity) {
        if ( entity == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setAccId( entity.getAccId() );
        accountDTO.setAccType( entity.getAccType() );
        accountDTO.setBalance( entity.getBalance() );

        return accountDTO;
    }

    @Override
    public Account toAccount(AccountDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Account account = new Account();

        account.setAccId( dto.getAccId() );
        account.setAccType( dto.getAccType() );
        account.setBalance( dto.getBalance() );

        return account;
    }

    @Override
    public TransactionPostDTO toTransPostDto(Transaction entity) {
        if ( entity == null ) {
            return null;
        }

        TransactionPostDTO transactionPostDTO = new TransactionPostDTO();

        transactionPostDTO.setSender( toDto( entity.getSender() ) );
        transactionPostDTO.setReceiver( toDto( entity.getReceiver() ) );
        transactionPostDTO.setAmount( entity.getAmount() );
        transactionPostDTO.setId( entity.getId() );

        return transactionPostDTO;
    }

    @Override
    public AccountTransactionDTO toAccTransDto(Account entity) {
        if ( entity == null ) {
            return null;
        }

        AccountTransactionDTO accountTransactionDTO = new AccountTransactionDTO();

        accountTransactionDTO.setTransmits( transactionListToTransmitDTOList( entity.getTransmits() ) );
        accountTransactionDTO.setReceives( transactionListToReceiveDTOList( entity.getReceives() ) );
        accountTransactionDTO.setAccId( entity.getAccId() );
        accountTransactionDTO.setAccType( entity.getAccType() );
        accountTransactionDTO.setBalance( entity.getBalance() );

        return accountTransactionDTO;
    }

    @Override
    public TransmitDTO toTransDto(Transaction entity) {
        if ( entity == null ) {
            return null;
        }

        TransmitDTO transmitDTO = new TransmitDTO();

        transmitDTO.setReceiver( entityReceiverAccId( entity ) );
        transmitDTO.setAmount( entity.getAmount() );
        transmitDTO.setId( entity.getId() );

        return transmitDTO;
    }

    @Override
    public ReceiveDTO toReceiveDto(Transaction entity) {
        if ( entity == null ) {
            return null;
        }

        ReceiveDTO receiveDTO = new ReceiveDTO();

        receiveDTO.setSender( entitySenderAccId( entity ) );
        receiveDTO.setAmount( entity.getAmount() );
        receiveDTO.setId( entity.getId() );

        return receiveDTO;
    }

    protected List<AccountDTO> accountListToAccountDTOList(List<Account> list) {
        if ( list == null ) {
            return null;
        }

        List<AccountDTO> list1 = new ArrayList<AccountDTO>( list.size() );
        for ( Account account : list ) {
            list1.add( toDto( account ) );
        }

        return list1;
    }

    protected List<TransmitDTO> transactionListToTransmitDTOList(List<Transaction> list) {
        if ( list == null ) {
            return null;
        }

        List<TransmitDTO> list1 = new ArrayList<TransmitDTO>( list.size() );
        for ( Transaction transaction : list ) {
            list1.add( toTransDto( transaction ) );
        }

        return list1;
    }

    protected List<ReceiveDTO> transactionListToReceiveDTOList(List<Transaction> list) {
        if ( list == null ) {
            return null;
        }

        List<ReceiveDTO> list1 = new ArrayList<ReceiveDTO>( list.size() );
        for ( Transaction transaction : list ) {
            list1.add( toReceiveDto( transaction ) );
        }

        return list1;
    }

    private int entityReceiverAccId(Transaction transaction) {
        Account receiver = transaction.getReceiver();
        if ( receiver == null ) {
            return 0;
        }
        return receiver.getAccId();
    }

    private int entitySenderAccId(Transaction transaction) {
        Account sender = transaction.getSender();
        if ( sender == null ) {
            return 0;
        }
        return sender.getAccId();
    }
}
