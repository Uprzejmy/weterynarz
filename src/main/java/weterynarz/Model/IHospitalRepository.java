package weterynarz.Model;

public interface IHospitalRepository extends IRepository<Hospital>{
	Hospital findBySpec(String spec);
}
