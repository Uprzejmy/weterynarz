package weterynarz.Model.Hospitals;

import weterynarz.Model.IRepository;

public interface IHospitalRepository extends IRepository<Hospital>{
	Hospital findBySpec(String spec);
}
