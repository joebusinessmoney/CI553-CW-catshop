package clients.shopDisplay;

public class AdvertController {

	private AdvertModel model = null;
	private AdvertView view = null;
	
	public AdvertController(AdvertModel model, AdvertView view) {
		this.view = view;
		this.model = model;
		
		model.addObserver(view);
	}
	
	public void nextImage() {
		model.nextImage();
	}
}
