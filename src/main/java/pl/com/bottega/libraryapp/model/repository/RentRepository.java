package pl.com.bottega.libraryapp.model.repository;

import pl.com.bottega.libraryapp.model.RentInformation;

public interface RentRepository {

    void put(RentInformation rentInformation);

    RentInformation get(Long rentId);
}
