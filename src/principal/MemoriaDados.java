package principal;

public class MemoriaDados {

	private String id;
	private String dado;

	public MemoriaDados() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDado() {
		return dado;
	}

	public void setDado(String dado) {
		this.dado = dado;
	}

	public String toString() {
		return "id=" + id + ", dado=" + dado;
	}

}
