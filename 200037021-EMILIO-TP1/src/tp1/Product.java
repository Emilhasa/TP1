package tp1;

public class Product {
	private String name;
	private String description;
	private double vBuy;
	private double pct;
	private double qtyStock;
	
	public Product(String name, String description, double vBuy, double pct, double qtyStock) {
		this.setName(name.toUpperCase());
		this.setDescription(description.toUpperCase());
		this.setVBuy(vBuy);
		this.setPct(pct);
		this.setQtyStock(qtyStock);
	}
	
	public void setName(String name) {
		this.name = name.toUpperCase();
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescription(String description) {
		this.description = description.toUpperCase();
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setVBuy(double vBuy) {
		this.vBuy = vBuy;
	}
	
	public double getVBuy() {
		return vBuy;
	}
	
	public void setPct(double pct) {
		this.pct = pct;
	}
	
	public double getPct() {
		return pct;
	}
	
	public void setQtyStock(double qtyStock) {
		this.qtyStock = qtyStock;
	}
	
	public double getQtyStock() {
		return qtyStock;
	}

	public void data() {
		System.out.println("Nome: " + this.getName());
		System.out.println("Descrição: " + this.getDescription());
		System.out.println("valor de compra: R$ " + this.getVBuy());
		System.out.println("Porcentagem de lucro: " + this.getPct() + " %");
		System.out.println("Quantidade em estoque: " + this.getQtyStock());
	}
	
	public void decreaseStock(double qtySell) {
		if (getQtyStock() > 0) {
			if (qtySell > getQtyStock()) {
				System.out.println("Quantidade solicitada acima da disponivel.");
			}else{
				setQtyStock(getQtyStock() - qtySell);
			}
			
		}else {
			System.out.println("Produto esgotado!");
		}
	}
}
