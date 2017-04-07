package pl.com.bottega.libraryapp.infrastructure;

import pl.com.bottega.libraryapp.model.RentInformation;
import pl.com.bottega.libraryapp.model.repository.RentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPARentRepository implements RentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void put(RentInformation rentInformation) {
        entityManager.persist(rentInformation);
    }

    @Override
    public RentInformation get(Long rentId) {
        RentInformation rentInformation = entityManager.find(RentInformation.class, rentId);
        return rentInformation;
    }
}
