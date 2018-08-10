This program is uses one main activity (MainActivity), and another activity to view the full size photo (PopupActivity).
The code was written on macOS using Android Studio 3.1.3.

The application automatically saves the state of the main activity every time you change the orientation of the phone (i.e. portrait to landscape). I'm not quite sure if this is considered as a requirement, but I added it in anyways for best practice. 

Upload photos from the resources by clicking the upload button on the top right corner of the application. To delete, click the trash button. All of the photos automatically start with a 5 star rating. The filter is also set to 5 stars. Clearing the filtering on the photo resets the photo to a 5 star rating.

You can only upload once. The upload button is disabled after all 10 images have been uploaded. You can re-enable this button if the images get deleted using the trash buttont. 

Clickiing on any photo will show the photo in full screen mode, click again to dismiss.
