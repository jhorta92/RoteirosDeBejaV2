<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Point extends Model
{
    use HasFactory;
    protected $fillable = [
        'routes_id','name', 'description','images','videoUrl','coordinate'
    ];

    public function routes()
    {
        return $this->belongsTo('App\Models\Route','routes_id');
    }

}
