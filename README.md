# Alerty 

Alerty is simple Dialog Library for Android.

# Latest Release

The latest release is available with 1.0.0.

    implementation 'com.github.volkanhotur-cci:Alerty:1.0.0-Alfa'
    
This repo has a sample project. And you can sample codes below:

new Alerty.Builder(this)
    .setTitle("Test Title")
    .setMessage("Test Message Dialog")
    .setCancellable(false)
    .setPositiveButtonText("OKAY")
    .setNegativeButtonText("CANCEL")
    .setHeaderImage(R.drawable.ic_message_red)
    .setPositiveButtonColor(0XFF828282)
    .setNegativeButtonColor(0XFF828282)
    .setButtonRadius(16f)
    .setDialogRadius(16f)
    .setTextAppearance(Alerty.MEDIUM_TEXT)
    .setTitleTextColor(0xFF000000)
    .setPositiveListener(new AlertyListener() {
        @Override
        public void onDialogClick(Dialog dialog) {
             Toast.makeText(MainActivity.this, "DONE!", Toast.LENGTH_SHORT).show();
        }
     })
     .build();
