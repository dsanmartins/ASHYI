package co.edu.javeriana.ASHYI.hbm;

import java.io.Serializable;

import co.edu.javeriana.ASHYI.model.Objetivo;
import co.edu.javeriana.ASHYI.model.PalabraClave;
import co.edu.javeriana.ASHYI.model.PalabraClaveObjetivo;

/**
 * @author ASHYI
 * @see PalabraClaveObjetivo
 */

public class PalabraClaveObjetivoImpl implements PalabraClaveObjetivo, Serializable{
	
	private Objetivo idObjetivo;
	private PalabraClave idPalabraClave;
	
	/**
	 * Constructor base
	 */
	public PalabraClaveObjetivoImpl()
	{}
	
	/**
	 * @param Objetivo asociado
	 * @param PalabraClave a relacionar
	 */
	public PalabraClaveObjetivoImpl(Objetivo objetivo, PalabraClave palabraClave) {
		super();
		this.idObjetivo = objetivo;
		this.idPalabraClave = palabraClave;
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.lessonbuildertool.model.PalabraClaveObjetivo#getIdObjetivo()
	 */
	public Objetivo getIdObjetivo() {
		return idObjetivo;
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.lessonbuildertool.model.PalabraClaveObjetivo#setIdObjetivo(org.sakaiproject.lessonbuildertool.model.Objetivo)
	 */
	public void setIdObjetivo(Objetivo idObjetivo) {
		this.idObjetivo = idObjetivo;
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.lessonbuildertool.model.PalabraClaveObjetivo#getIdPalabraClave()
	 */
	public PalabraClave getIdPalabraClave() {
		return idPalabraClave;
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.lessonbuildertool.model.PalabraClaveObjetivo#setIdPalabraClave(org.sakaiproject.lessonbuildertool.model.PalabraClave)
	 */
	public void setIdPalabraClave(PalabraClave idPalabraClave) {
		this.idPalabraClave = idPalabraClave;
	}
	
}