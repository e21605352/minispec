public class Satellite {
	String Nom;
	Integer Id;

	public Satellite(String Nom, Integer Id) {
		this.Nom = Nom;
		this.Id = Id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String Nom) {
		this.Nom = Nom;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}
}