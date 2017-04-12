package it.uniroma3.db.products;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;	
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;
    @ManyToOne
    private Customer customer;
    
    @OneToMany 
    @JoinColumn(name = "orders_id")
    private List<OrderLine> orderLines;
    
	public Order() {
	}
    
	public Long getId() {
		return id;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
    public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

}
