package com.estudo.minhasfinancas.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Intermediario {
	@Embeddable
	public static class Pk implements Serializable {
    
		private static final long serialVersionUID = -8469992858735987146L;

		@Column(name="profile",nullable = false, updatable = false)
        private Long profile;

   

        @Column(name="module",nullable = false, updatable = false)
        private Long module;
        
        @Column(name="usert",nullable = false, updatable = false)
        private Long usert;

        public Pk() {}

        
		public Pk(Long profile, Long module, Long usert) {
			super();
			this.profile = profile;
			this.module = module;
			this.usert = usert;
		}


		public Long getProfile() {
			return profile;
		}

		public void setProfile(Long profile) {
			this.profile = profile;
		}

		public Long getModule() {
			return module;
		}

		public void setModule(Long module) {
			this.module = module;
		}

		public Long getUsert() {
			return usert;
		}

		public void setUsert(Long usert) {
			this.usert = usert;
		}

	
      }
	
    @EmbeddedId
    private Pk pk;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MODULE", insertable = false, updatable = false)
    private Module module ;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROFILE", insertable = false, updatable = false)
    private Profile profile;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USERT", insertable = false, updatable = false)
    private Usert usert;
  
	public Pk getPk() {
		return pk;
	}
	public void setPk(Pk pk) {
		this.pk = pk;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public Usert getUsert() {
		return usert;
	}
	public void setUsert(Usert usert) {
		this.usert = usert;
	}

	
    
    


}
