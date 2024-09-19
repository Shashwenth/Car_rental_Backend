package com.CarRental.Backend.Service;


import com.CarRental.Backend.Entities.CarModel;
import com.CarRental.Backend.Entities.Customer;
import com.CarRental.Backend.Entities.Lease;
import com.CarRental.Backend.Repositories.CarModelJPA;
import com.CarRental.Backend.Repositories.CustomerJPA;
import com.CarRental.Backend.Repositories.ExpiredLeaseJPA;
import com.CarRental.Backend.Repositories.LeaseJPA;
import org.springframework.stereotype.Service;

@Service
public class HandleReturn {

    private LeaseJPA leaseJPA;
    private Lease lease;
    private CarModelJPA carModelJPA;
    private CustomerJPA customerJPA;
    private ExpiredLeaseJPA expiredLeaseJPA;


    public HandleReturn(LeaseJPA leaseJPA, CarModelJPA carModelJPA, CustomerJPA customerJPA, ExpiredLeaseJPA expiredLeaseJPA) {
        System.out.println("Constructor Inititialization Started");
        this.leaseJPA = leaseJPA;
        this.carModelJPA = carModelJPA;
        this.customerJPA = customerJPA;
        this.expiredLeaseJPA = expiredLeaseJPA;
    }


    public void UpdateCar(Lease lease) {
        CarModel carModel = carModelJPA.findByCarId(lease.getCarModel().getCarId());
        carModel.setCarAvailable(true);
        expiredLeaseJPA.save(lease);
        carModel.setCarLeasedTo(null);
        carModelJPA.save(carModel);
    }

    public void UpdateCustomer(Lease lease) {
        System.out.println(1);
        Customer customer = customerJPA.findByCustomerId(lease.getCustomer().getCustomerId());
        System.out.println(2);
        customer.setCustomerCurrentActiveLeasesCount(customer.getCustomerCurrentActiveLeasesCount() - 1);
        System.out.println(3);
        customer.getCustomerActiveLeaseSet().remove(lease);
        customerJPA.save(customer);
    }

}
