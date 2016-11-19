      //WRITE_EXTERNAL_STORAGE permission diğer permissionlarla değiştirilebilir    
          
          // Identifier for the permission request
                final int WRITE_EXTERNAL_STORAGE_REQUEST = 1;

                if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
                    boolean hasPermission = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED;
                    if(!hasPermission) {
                        if(shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                            // explain reason for permission, try again
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_REQUEST);
                            Toast.makeText(MainActivity.this,"Güncelleme yapmak için lütfen izin verin.", Toast.LENGTH_LONG).show();
                        } else {
                            // user deny with "don't show again"
                            Toast.makeText(MainActivity.this,"Uygulama ayarlarınıdan indirme iznini etkinleştirmeniz gerekmektedir.", Toast.LENGTH_LONG).show();
                        }
                    }
                    else{
                        guncelle();
                    }
                }
