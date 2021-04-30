# Simple REALM Database In Android

### Configuring Realm in Android
Add the following classpath in your root build.gradle file:

```sh
buildscript {
    ...
    dependencies {
        ...
        classpath 'io.realm:realm-gradle-plugin:3.2.1'
    }
}
````
Add the following plugin to the app’s build.gradle


```sh

apply plugin: 'realm-android'
```
### Creating a Realm Instance

To create a Realm instance we do the following:

```sh

Realm mRealm = Realm.getInstance(context);
```
We can also pass a RealmConfiguration instance inside the getInstance()

```sh

RealmConfiguration config =
                new RealmConfiguration.Builder()
                        .name("test.db")
                        .schemaVersion(1)
                        .deleteRealmIfMigrationNeeded()
                        .build();

```
### Creating Realm Model class

To create Model classes, extend them with RealmObject.
Primary keys can be of String or integer type and are annotated with @PrimaryKey annotation.

### Following are some annotations commonly used on Realm Model classes:
 
@PrimaryKey
@Required – Cannot be null
@Index – Add this on fields you are using in Query. It makes the queries 4X faster.
@Ignore
Writing Data to Realm
You can write data to Realm in the following ways:

```sh

Realm realm = Realm.getDefaultInstance();
realm.beginTransaction();
realm.copyToRealm(realmModelInstance)
realm.commitTransaction();
```
There is a problem with the above approach though. It doesn’t cancel the transaction if failed.
Hence it is not the recommended way to insert data into the Database.

The method executeTranscation or executeTranscationAsync automatically handle the cancel transaction.

```sh

Realm realm = Realm.getDefaultInstance();
    realm.executeTransaction(new Realm.Transaction() {
        @Override
        public void execute(Realm realm) {
            realm.insertOrUpdate(realmModelInstance);
        }
    });
```
Also, we can add a try-catch inside the executeTranscation to catch exceptions. Try-catch is ignored by the earlier approach though.


insertOrUpdate or copyToRealmOrUpdate are used to insert if the primary key doesn’t exist or update the current object if the primary key exists.
Read From Realm
```sh

RealmResults<RealModelClass> results = realm.where(RealModelClass.class).findAll();
```
Again it’s a good practice to use this inside the execute method.

###### Delete From Realm
```sh

mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<RealModelClass> results = realm.where(RealModelClass.class).findAll();
                results.deleteAllFromRealm();
            }
        });
```
###### Following are the other methods that can be used to delete the results:

###### android realm delete functions

RealmList is a built-in collection of RealmObjects and is used for model one-to-many relationships.

RealmList cannot support non-realm objects(such as Long, String, Integer).

In the following section, we’ll be creating a basic Android Application which uses Realm and performs CRUD operations.




## License

MIT

**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   
